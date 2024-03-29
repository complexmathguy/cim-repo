/**
 * ***************************************************************************** Turnstone Biologics
 * Confidential
 *
 * <p>2018 Turnstone Biologics All Rights Reserved.
 *
 * <p>This file is subject to the terms and conditions defined in file 'license.txt', which is part
 * of this source code package.
 *
 * <p>Contributors : Turnstone Biologics - General Release
 * ****************************************************************************
 */
package com.occulue.europeanstandards.commongridmodelexchangestandard.steadystatehypothesisprofile.wires.controller.query;

import com.occulue.api.*;
import com.occulue.controller.*;
import com.occulue.controller.query.*;
import com.occulue.delegate.*;
import com.occulue.entity.*;
import com.occulue.exception.*;
import com.occulue.projector.*;
import java.util.*;
import java.util.concurrent.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.springframework.web.bind.annotation.*;

/**
 * Implements Spring Controller query CQRS processing for entity SwitchIt.
 *
 * @author your_name_here
 */
@CrossOrigin
@RestController
@RequestMapping("/SwitchIt")
public class SwitchItQueryRestController extends BaseSpringRestController {

  /**
   * Handles loading a SwitchIt using a UUID
   *
   * @param UUID switchItId
   * @return SwitchIt
   */
  @GetMapping("/load")
  public SwitchIt load(@RequestParam(required = true) UUID switchItId) {
    SwitchIt entity = null;

    try {
      entity =
          SwitchItBusinessDelegate.getSwitchItInstance()
              .getSwitchIt(new SwitchItFetchOneSummary(switchItId));
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load SwitchIt using Id " + switchItId);
      return null;
    }

    return entity;
  }

  /**
   * Handles loading all SwitchIt business objects
   *
   * @return Set<SwitchIt>
   */
  @GetMapping("/")
  public List<SwitchIt> loadAll() {
    List<SwitchIt> switchItList = null;

    try {
      // load the SwitchIt
      switchItList = SwitchItBusinessDelegate.getSwitchItInstance().getAllSwitchIt();

      if (switchItList != null) LOGGER.log(Level.INFO, "successfully loaded all SwitchIts");
    } catch (Throwable exc) {
      LOGGER.log(Level.WARNING, "failed to load all SwitchIts ", exc);
      return null;
    }

    return switchItList;
  }

  // ************************************************************************
  // Attributes
  // ************************************************************************
  protected SwitchIt switchIt = null;
  private static final Logger LOGGER =
      Logger.getLogger(SwitchItQueryRestController.class.getName());
}
