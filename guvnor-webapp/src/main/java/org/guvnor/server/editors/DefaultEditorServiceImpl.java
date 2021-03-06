/*
 * Copyright 2014 Red Hat, Inc. and/or its affiliates.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *       http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.guvnor.server.editors;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;
import javax.inject.Named;

import org.guvnor.common.services.backend.util.CommentedOptionFactory;
import org.guvnor.shared.editors.DefaultEditorService;
import org.jboss.errai.bus.server.annotations.Service;
import org.uberfire.backend.server.util.Paths;
import org.uberfire.backend.vfs.Path;
import org.uberfire.io.IOService;

@Service
@ApplicationScoped
public class DefaultEditorServiceImpl
        implements DefaultEditorService {

    @Inject
    @Named("ioStrategy")
    private IOService ioService;

    @Inject
    protected CommentedOptionFactory commentedOptionFactory;

    @Override
    public Path save( final Path path,
                      final String content,
                      final String commitMessage ) {

        ioService.write( Paths.convert( path ),
                         content,
                         commentedOptionFactory.makeCommentedOption( commitMessage ) );

        return path;
    }
}
